/* PBNI - Changing Lives */

document.addEventListener('deviceready', function () {
    deviceReady();
});

function deviceReady() {

    angular.element(document).ready(function () {
        angular.bootstrap(document, ['pbni']);
    });

}

var app = angular.module('pbni', ['ionic', 'jett.ionic.filter.bar']);

app.factory('data', function ($http, $q, $rootScope) {

    var cachedData = false;

    function doLoad() {
        var deferred = $q.defer();
        $http.get('http://changinglivesapp.com/api/feed.php', {timeout: 5000}).then(function(res) {
            localStorage.setItem('cachedData', JSON.stringify(res.data));
            deferred.resolve(res.data);
        }, function () {
            if (localStorage.getItem('cachedData')) {
                var data = JSON.parse(localStorage.getItem('cachedData'));
                deferred.resolve(data);
            } else {
                $http.post('js/content.json').then(function (res) {
                    deferred.resolve(res.data);
                });
            }
        });
        return deferred.promise;
    }
    
    function loadFeed() {
        var promise = doLoad();
        return promise.then(function(data) {
            cachedData = data;
            return cachedData;
        });
    }

    function getPage(id) {
        var pages = cachedData.pages;
        for (var i = 0; i < pages.length; i++) {
            if (pages[i].id == id) {
                return pages[i];
            }
        }
    }

    function getSection(page, id) {
        var sections = page.sections;
        for (var i = 0; i < sections.length; i++) {
            if (sections[i].id == id) {
                return sections[i];
            }
        }
    }

    function getEntry(section, id) {
        var entries = section.entries;
        for (var i = 0; i < entries.length; i++) {
            if (entries[i].id == id) {
                return entries[i];
            }
        }
    }

    return {
        getFeed: function () {
            return loadFeed();
        },
        getPage: function (id) {
            return getPage(id);
        },
        getSection: function (page, id) {
            return getSection(page, id);
        },
        getEntry: function (section, id) {
            return getEntry(section, id);
        }
    }

});

app.run(function ($ionicPlatform, $rootScope) {

    $ionicPlatform.ready(function () {
        if (window.cordova && window.cordova.plugins && window.cordova.plugins.Keyboard) {
            cordova.plugins.Keyboard.hideKeyboardAccessoryBar(false);
            cordova.plugins.Keyboard.disableScroll(true);
        }
        if (window.StatusBar) {
            StatusBar.styleLightContent();
        }
    });

});

app.config(function ($stateProvider, $urlRouterProvider, $ionicConfigProvider, $ionicFilterBarConfigProvider) {

    $ionicConfigProvider.backButton.previousTitleText(false);
    $ionicConfigProvider.tabs.position('bottom');
    $ionicFilterBarConfigProvider.transition('none');

    $stateProvider
        .state('tab', {
            url: '/page',
            abstract: true,
            templateUrl: 'templates/tabs.html'
        })
        .state('tab.page', {
            url: '/:page',
            templateUrl: function (params) {
                switch (parseInt(params.page)) {
                case 6:
                    // Journal
                    return 'templates/journal/index.html';
                    break;
                case 7:
                    // Appointments
                    return 'templates/appointments/index.html';
                    break;
                case 3:
                    // Addiction
                    return 'templates/addiction/index.html';
                    break;
                case 2:
                    // Mental Health
                    return 'templates/mental-health/index.html';
                    break;
                default:
                    return 'templates/index.html';
                    break;
                }
            },
            cache: false
        })
        .state('tab.section', {
            url: '/:page/section/:section',
            templateUrl: function (params) {
                switch (parseInt(params.page)) {
                case 5:
                    // Contact Groups
                    return 'templates/contacts/group.html';
                    break;
                default:
                    switch (parseInt(params.section)) {
                    case 31:
                        return 'templates/mental-health/websites.html';
                        break;
                    default:
                        return 'templates/entry.html';
                        break;
                    }
                    break;
                }
            },
            cache: false
        })
        .state('tab.entry', {
            url: '/:page/section/:section/entry/:entry',
            templateUrl: function (params) {
                switch (parseInt(params.page)) {
                case 5:
                    // Contact
                    return 'templates/contacts/entry.html';
                    break;
                case 6:
                    // Journal
                    return 'templates/journal/entry.html';
                    break;
                case 7:
                    // Appointments
                    return 'templates/appointments/entry.html';
                    break;
                default:
                    return 'templates/entry.html';
                    break;
                }
            },
            cache: false
        });

    $urlRouterProvider.otherwise('/page/6');

});

app.filter('dateSuffix', function ($filter) {

    var suffixes = ["th", "st", "nd", "rd"];
    return function (input) {
        var dtfilter = $filter('date')(input, 'MMMM dd');
        var day = parseInt(dtfilter.slice(-2));
        var relevantDigits = (day < 30) ? day % 20 : day % 30;
        var suffix = (relevantDigits <= 3) ? suffixes[relevantDigits] : suffixes[0];
        return suffix;
    };

});

app.filter('reverse', function () {

    return function (items) {
        return items.slice().reverse();
    };

});

app.filter('capitalize', function () {
    return function (input) {
        return (!!input) ? input.charAt(0).toUpperCase() + input.substr(1).toLowerCase() : '';
    }
});

app.directive("calendar", function () {

    return {
        restrict: "E",
        templateUrl: "templates/calendar.html",
        scope: {
            selected: "="
        },
        controller: function($rootScope, $scope){
            
            $scope.selected = _removeTime(angular.copy($rootScope.selectedDate) || moment());
            $scope.month = $scope.selected.clone();
            
            var start = $scope.selected.clone();
            start.date(1);
            
            _removeTime(start.day(0));
            _buildMonth($scope, start, $scope.month, $rootScope.appointments);
            
            $scope.select = function(pos){
                $scope.selected = pos.date;
                $rootScope.selectedDate = pos.date;
            };
            
            if (typeof $rootScope.selectedDate != 'undefined') {
                $scope.selected = angular.copy($rootScope.selectedDate);
            } else {
                $rootScope.selectedDate = angular.copy($scope.selected);
            }
            
            $scope.$watch('selected', function () {
                $rootScope.appointmentsThisDay = [];
                for (var i = 0; i < $rootScope.appointments.length; i++) {
                    if (new Date($rootScope.appointments[i].date).toDateString() == new Date($scope.selected).toDateString()) {
                        $rootScope.appointments[i].index = i;
                        $rootScope.appointmentsThisDay.push($rootScope.appointments[i]);
                    }
                }
            });
            
        },
        link: function (scope, $rootScope) {

            scope.next = function () {
                var next = scope.month.clone();
                _removeTime(next.month(next.month() + 1).date(1));
                scope.month.month(scope.month.month() + 1);
                _buildMonth(scope, next, scope.month, $rootScope.appointments);
            };

            scope.previous = function () {
                var previous = scope.month.clone();
                _removeTime(previous.month(previous.month() - 1).date(1));
                scope.month.month(scope.month.month() - 1);
                _buildMonth(scope, previous, scope.month, $rootScope.appointments);
            };
            
        }
    };

    function _removeTime(date) {
        if (Math.abs(new Date(date).getTime() - new Date().getTime()) < 1000) {
            return date.day(new Date(date).getDay()).hour(0).minute(0).second(0).millisecond(0);
        } else {
            return date.day(0).hour(0).minute(0).second(0).millisecond(0);
        }
    }

    function _buildMonth(scope, start, month, appointments) {
        scope.weeks = [];
        var done = false,
            date = start.clone(),
            monthIndex = date.month(),
            count = 0;
        while (!done) {
            scope.weeks.push({
                days: _buildWeek(date.clone(), month, appointments)
            });
            date.add(1, "w");
            done = count++ > 2 && monthIndex !== date.month();
            monthIndex = date.month();
        }
    }

    function _buildWeek(date, month, appointments) {
        var days = [];
        for (var i = 0; i < 7; i++) {
            days.push({
                name: date.format("dd").substring(0, 1),
                number: date.date(),
                isCurrentMonth: date.month() === month.month(),
                isToday: date.isSame(new Date(), "day"),
                date: date,
                eventsToday: _appointmentsToday(date, appointments)
            });
            date = date.clone();
            date.add(1, "d");
        }
        return days;
    }
    
    function _appointmentsToday(date, appointments) {
        var count = 0;
        if (!appointments) {
            return count;
        }
        for (var i = 0; i < appointments.length; i++) {
            if (new Date(appointments[i].date).toDateString() == new Date(date).toDateString()) {
                count = count+1;
            }
        }
        return count;
    }
    
});

app.controller('ctrl', function ($rootScope, $scope, $http, $state, $interval, $timeout, $stateParams, $ionicFilterBar, $ionicSlideBoxDelegate, $ionicScrollDelegate, $sce, $compile, $location, $ionicHistory, $ionicModal, data) {

    // Original page names for classes
    $scope.originalPageNames = ['probation', 'mental', 'addiction', 'victims', 'contacts', 'journal', 'appointments', 'about'];

    $scope.daysList = new Array('Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday');
    
    $scope.monthsList = new Array('January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December');
    
    $scope.reminderTimes = [
        {title: 'At time of event', mins: 0}, 
        {title: '5 minutes before', mins: 5}, 
        {title: '15 minutes before', mins: 15}, 
        {title: '30 minutes before', mins: 30}, 
        {title: '1 hour before', mins: 60}, 
        {title: '2 hours before', mins: 120}, 
        {title: '1 day before', mins: 1440}, 
        {title: '2 days before', mins: 2880}, 
        {title: '1 week before', mins: 10080}
    ];
    
    $scope.download = function () {
        data.getFeed().then(function (result) {
            $scope.dataModel = result;
            console.log('Feed downloaded successfully.');
            $scope.init();
            navigator.splashscreen.hide();
        }).finally(function () {
            $scope.$broadcast('scroll.refreshComplete');
        });
    }

    //$scope.journal = new Object;
    
    $scope.init = function () {
        $scope.page = data.getPage($stateParams.page);
        $scope.view = $scope.originalPageNames[$scope.page.id - 1];
        switch (parseInt($scope.page.id)) {
        case 6:
            // The journal doesn't have traditional content, i.e. 'sections' and 'entries'
            $scope.updateJournal();
            $scope.entry = $stateParams.entry == 'new' ? {
                new: true
            } : angular.copy($scope.journal[$scope.journalSelected.year][$scope.journalSelected.month][$stateParams.entry]);
            break;
        case 7:
            // Appointments don't have traditional content, i.e. 'sections' and 'entries'
            if ($stateParams.entry == 'new') {
                var setDate = new Date($rootScope.selectedDate),
                    nowDate = new Date();
                    setDate.setHours(nowDate.getHours());
                    setDate.setMinutes(nowDate.getMinutes());
                $scope.entry = { 
                    new: true,
                    date: setDate,
                    reminders: []
                };
            } else {
                $scope.entry = angular.copy($rootScope.appointments[$stateParams.entry]);
                if ($scope.entry) {
                    $scope.entry.date = new Date($scope.entry.date);
                }
            }
            break;
        case 5:
            $scope.section = typeof $stateParams.section == 'undefined' ? false : ($stateParams.section == 0 ? 0 : data.getSection($scope.page, $stateParams.section));
            if (typeof $stateParams.entry == 'undefined') {
                $scope.entry =  false;
            } else {
                if ($stateParams.entry == 'new') {
                    $scope.entry = {
                        fields: {}
                    };
                } else {
                    if ($scope.section) {
                        $scope.entry = data.getEntry($scope.section, $stateParams.entry);
                    } else {
                        $scope.entry = $scope.myContacts.entries[$stateParams.entry];
                    }
                }
            }
            break;
        default:
            $scope.section = typeof $stateParams.section == 'undefined' ? false : data.getSection($scope.page, $stateParams.section);
            $scope.entry = typeof $stateParams.entry == 'undefined' ? false : data.getEntry($scope.section, $stateParams.entry);
            break;
        }
    }

    $scope.$on('$stateChangeSuccess', function () {
        $scope.dataModel ? $scope.init() : $scope.download();
    });

    // Journal

    $scope.now = new Date();
    $scope.emotions = new Array('happy', 'fine', 'anxious', 'frustrated', 'good', 'indifferent', 'unhappy', 'angry');
    
    $interval(function () {
        $scope.now = new Date();
        if (typeof $scope.journal != 'undefined' && $scope.journal != 'undefined') {
            $scope.updateJournal();
        }
    }, 1000);

    $scope.updateJournal = function () {
        if (typeof $scope.journal == 'undefined') {
            return false;
        }
        if (typeof Object.keys($scope.journal)[0] == 'undefined') {
            var startDate = new Date($scope.now);
        } else {
            var year = Object.keys($scope.journal)[0];
            var month = Object.keys($scope.journal[year])[0];
            var startDate = new Date(year, month, 1);
        }
        var endDate = new Date($scope.now);
        endDate = new Date(endDate.getFullYear(), endDate.getMonth() + 1, 0, 23, 59, 59);
        for (var d = new Date(startDate); d <= endDate; d.setMonth(d.getMonth() + 1)) {
            var year = d.getFullYear();
            var month = d.getMonth();
            if (!$scope.journal.hasOwnProperty(year)) {
                $scope.journal[year] = new Object;
            }
            if (!$scope.journal[year].hasOwnProperty(month)) {
                $scope.journal[year][month] = new Array();
            }
        }
    }

    $scope.onInitFs = function (fs) {
        fs.root.getFile('journal.txt', {}, function (fileEntry) {
            fileEntry.file(function (file) {
                var reader = new FileReader();
                reader.onloadend = function (e) {
                    if (this.result == '' || this.result == 'undefined') {
                        $scope.journal = new Object;
                    } else {
                        try{
                            JSON.parse(this.result);
                        }catch(e){
                           $scope.journal = new Object;
                           return false;
                        }
                        $scope.journal = JSON.parse(this.result);
                    }
                }
                reader.readAsText(file);
            });
        }, function (e) {
            $scope.journal = new Object;
        });
    }

    /* Request file system (used for storing journal entries) */
    window.requestFileSystem = window.requestFileSystem || window.webkitRequestFileSystem;
    window.requestFileSystem(LocalFileSystem.PERSISTENT, 0, $scope.onInitFs, function () {
        return false;
    });

    $scope.journalScroll = function () {
        var top = $ionicScrollDelegate.getScrollPosition().top;
        var monthSlider = document.getElementsByClassName('select-month')[0];
        var dateTime = document.getElementsByClassName('datetime')[0];
        var offset = top < 0 ? top : 0;
        dateTime.style.webkitTransform = 'translate3d(0, ' + offset + 'px, 0)';
    }

    $scope.slideHasChanged = function (index) {
        $scope.journalIndex = index;
        $scope.journalSelected = $scope.journalMonths[index];
    }

    $scope.timeOfDay = function (time) {
        var tod = '';
        if ((time.getHours() >= 0 && time.getHours() < 6) || (time.getHours() > 17 && time.getHours() < 24)) {
            tod = 'night';
        } else if (time.getHours() > 5 && time.getHours() < 12) {
            tod = 'morning';
        } else {
            tod = 'afternoon';
        }
        return tod;
    }

    $scope.updateJournalEntry = function (entry) {
        var d = $stateParams.entry == 'new' ? (entry.date = new Date()) : new Date(entry.date);
        var j = $scope.journal[d.getFullYear()][d.getMonth()];
        delete entry.new;
        $stateParams.entry == 'new' ? j.push(entry) : j[$stateParams.entry] = angular.copy(entry);
        $location.url('/page/6');
    }

    $scope.deleteJournalEntry = function () {
        navigator.notification.confirm('Are you sure you want to delete this journal entry?', function (buttonIndex) {
            if (buttonIndex == 2) {
                var d = new Date($scope.entry.date);
                $scope.journal[d.getFullYear()][d.getMonth()].splice($stateParams.entry, 1);
                $scope.$apply();
                $location.url('/page/6');
            }
        }, 'Confirm', ['No', 'Yes']);
    }

    $scope.$watch('journal', function () {
        if (typeof $scope.journal == 'undefined') {
            return false;
        }
        // Write journal to .txt file
        window.requestFileSystem(LocalFileSystem.PERSISTENT, 0, function (fs) {
            fs.root.getFile('journal.txt', {
                create: true
            }, function (fileEntry) {
                fileEntry.createWriter(function (fileWriter) {
                    fileWriter.onwriteend = function (e) {
                        console.log('Journal saved to file');
                    };
                    fileWriter.onerror = function (e) {
                        console.log('An unknown error occured');
                    };
                    if (typeof $scope.journal != 'undefined') {
                        fileWriter.write(JSON.stringify($scope.journal));
                    }
                }, function () {
                    console.log('An unknown error occured');
                });
            }, function () {
                console.log('An unknown error occured');
            });
        }, function () {
            return false;
        });
        $scope.updateJournal();
        $scope.journalMonths = new Array();
        angular.forEach($scope.journal, function (value, key) {
            var year = key;
            angular.forEach($scope.journal[year], function (value, key) {
                var obj = {
                    year: year,
                    month: key
                };
                $scope.journalMonths.push(obj);
            });
        });
        $timeout(function () {
            $ionicSlideBoxDelegate.update();
            $scope.journalIndex = $scope.journalMonths.length - 1;
            $scope.journalSelected = $scope.journalMonths[$scope.journalMonths.length - 1];
            $ionicSlideBoxDelegate.slide($scope.journalMonths.length - 1, 0);
        }, 20);
    }, true);

    // Addiciton (Open / Close tips)

    $scope.openTip = function (entry) {
        if (!entry.open) {
            angular.forEach($scope.page.sections[0].entries, function (value, key) {
                value.open = false;
            });
            entry.open = true;
        } else {
            entry.open = false;
        }
    }

    // Contacts

    if (localStorage.getItem('contacts') && localStorage.getItem('contacts') != 'undefined') {
        $scope.myContacts = {
            entries: JSON.parse(localStorage.getItem('contacts'))
        };
    } else {
        $scope.myContacts = {
            entries: []
        };
    }
    
    $scope.openWeb = function (url) {
        var ref = cordova.InAppBrowser.open(url, '_blank', 'location=yes');
    }

    $scope.callContact = function (number) {
        document.location.href = 'tel:' + number;
    }
    
    $scope.emailContact = function (email) {
        document.location.href = 'mailto:' + email;
    }
    
    $scope.updateContact = function (entry) {
        if ($stateParams.entry == 'new') {
            $scope.myContacts.entries.push(angular.copy($scope.entry));
        } else {
            $scope.myContacts.entries[$stateParams.entry] = angular.copy($scope.entry);
        }
        $ionicHistory.goBack();
    }

    $scope.deleteContact = function () {
        navigator.notification.confirm('Are you sure you want to delete this contact?', function (buttonIndex) {
            if (buttonIndex == 2) {
                $scope.myContacts.entries.splice($stateParams.entry, 1);
                $scope.$apply();
                $ionicHistory.goBack();
            }
        }, 'Confirm', ['No', 'Yes']);
    }
    
    $scope.$watch('myContacts', function () {
        localStorage.setItem('contacts', JSON.stringify($scope.myContacts.entries));
    }, true);
    
    // Appointments
    
    if (localStorage.getItem('appointments') && localStorage.getItem('appointments') != 'undefined') {
        $rootScope.appointments = JSON.parse(localStorage.getItem('appointments'));
    } else {
        $rootScope.appointments = [];
    }
    
    $scope.updateAppointmentEntry = function (entry) {
        if (entry.notifications) {
            // Clear existing notifications
            cancelNotification(entry.notifications);
            //for (var i = 0; i < entry.notifications.length; i++) {
            //    cancelNotification(entry.notifications[i]);
            //}
        }
        if (entry.reminders) {
            entry.notifications = [];
            for (var i = 0; i < entry.reminders.length; i++) {
                entry.notifications.push(setNotification(entry, entry.reminders[i]));
            }
        }
        delete entry.new;
        $stateParams.entry == 'new' ? $rootScope.appointments.push(entry) : $rootScope.appointments[$stateParams.entry] = angular.copy(entry);
        $location.url('/page/7');
    }
    
    $scope.deleteAppointment = function (entry) {
        navigator.notification.confirm('Are you sure you want to delete this appointment?', function (buttonIndex) {
            if (buttonIndex == 2) {
                if (entry.notifications) {
                    cancelNotification(entry.notifications);
                }
                $rootScope.appointments.splice(entry.index, 1);
                $rootScope.$apply();
                $location.url('/page/7');
            }
        }, 'Confirm', ['No', 'Yes']);
    }
    
    $scope.time = function(t) {
        t = new Date(t);
        return pad(t.getHours(),2)+':'+pad(t.getMinutes(),2)+' '+(t.getHours() > 11 ? 'PM' : 'AM');
    }
    
    $scope.toggleReminderSelection = function(mins) {
        var index = $scope.entry.reminders.indexOf(mins);
        if (index == -1) {
            $scope.entry.reminders.push(mins);
        } else {
            $scope.entry.reminders.splice(index, 1);
        }
    }
    
    $scope.reminderSet = function(mins, entry) {
        if (typeof entry != 'undefined') {
            return entry.reminders.indexOf(mins) > -1 ? true : false;
        }
    }
    
    function setNotification(entry, mins) {
        var notificationID = Math.round(Math.random()*1000000);
        var eventDate = new Date(entry.date);
        var d = new Date(entry.date);
        d.setTime(d.getTime() - (mins * 60 * 1000));
        var text = 'Reminder for ' + entry.title + ' on ' + $scope.daysList[eventDate.getDay()] + ' ' + ordinal_suffix_of(eventDate.getDate()) + ' ' +  $scope.monthsList[eventDate.getMonth()] + ' at ' + (eventDate.getHours() > 12 ? eventDate.getHours() - 12 : eventDate.getHours()) + ':' + pad(eventDate.getMinutes(), 2) + (eventDate.getHours() > 11 ? 'PM' : 'AM');
        cordova.plugins.notification.local.schedule({
            id: notificationID,
            title: 'Appointment Reminder',
            text: text,
            at: d,
            sound: null
        });
        return notificationID;
    }

    function cancelNotification(id) {
        cordova.plugins.notification.local.cancel([id]);
    }
    
    $scope.$watch('appointments', function () {
        localStorage.setItem('appointments', JSON.stringify($rootScope.appointments));
    }, true);
    
    // Helpful Websites

    $scope.shortenURL = function (url) {
        return url.split('/')[0];
    }

    // Filter Bar

    var filterBarInstance;

    $scope.showFilterBar = function (filter) {
        filterBarInstance = $ionicFilterBar.show({
            items: filter,
            update: function (filteredItems, filterText) {
                $scope.filterText = filterText;
            }
        });
    }

    $scope.highlight = function (text, search) {
        if (!search) {
            return $sce.trustAsHtml(text);
        }
        return $sce.trustAsHtml(text.replace(new RegExp(RegExp.quote(search), 'gi'), '<span class="highlightedText">$&</span>'));
    };

    $scope.$watch('filterText', function () {
        $scope.filterCount = 1;
        $timeout(function () {
            $scope.filterCount = document.getElementsByClassName('highlightedText').length;
        }, 300);
    });
    
    // Video 
    
    $ionicModal.fromTemplateUrl('templates/video/modal.html', {
        scope: $scope,
        animation: 'slide-in-up'
    }).then(function(modal) {
        $scope.videoModal = modal;
    });
    
    $scope.openVideo = function () {
        $scope.videoModal.show();
    }
    
    $scope.closeVideo = function () {
        var video = document.getElementById("video"); 
        video.pause(); 
        video.currentTime = 0;
        $scope.videoModal.hide();
    }

    RegExp.quote = function (str) {
        return (str + '').replace(/[.?*+^$[\]\\(){}|-]/g, "\\$&");
    };

    $(document).on('click', 'a[href]', function (e) {
        e.preventDefault();
        var href = $(this).attr('href');
        if (href.indexOf('http:') > -1) {
            $scope.openWeb(href);
        } else if (href.indexOf('mailto:') > -1) {
            $scope.emailContact(href.split(':')[1]);
        } else if (href.indexOf('tel:') > -1) {
            $scope.callContact(href.split(':')[1]);
        }
    });

});

function pad(num, size) {
    var s = num+"";
    while (s.length < size) s = "0" + s;
    return s;
}

function ordinal_suffix_of(i) {
    var j = i % 10,
        k = i % 100;
    if (j == 1 && k != 11) {
        return i + "st";
    }
    if (j == 2 && k != 12) {
        return i + "nd";
    }
    if (j == 3 && k != 13) {
        return i + "rd";
    }
    return i + "th";
}