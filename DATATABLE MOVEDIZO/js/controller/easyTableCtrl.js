angular.module('angularPageApp')

.controller('easyTableCtrl', function($scope) {
    // define an arry to hold the table data
    $scope.items = [];
    $scope.headers = ['job name', 'company', 'client', 'status'];

    // color presets
    $scope.colorPresets = ['#941C2F', '#2B4162', '#00B563', '#D63300', '#E31044', '#476A6F'];
    $scope.presetIndex = 1;
    $scope.presetsOpen = false;

    // help popout
    $scope.helpItems = [
        'Click a row to access it\'s <span>Action Menu</span>.',
        'Click <span>View</span> to see additional record information.',
        'Click <span>Edit</span> to change any editable record fields.',
        'Click <span>Delete</span> and confirm to remove a record permanently.'
    ];
    $scope.helpOpen = false;

    // define view state variables
    $scope.viewActive = false;
    $scope.editActive = false;
    $scope.deleteActive = false;

    // defined active view data object
    $scope.viewItem = {};

    // define what to do when the use clicks off the table area
    $scope.onClickAway = function($event) {
        $event.stopPropagation();
        $scope.helpOpen = false;
        if ($scope.viewActive === true || $scope.editActive === true || $scope.deleteActive === true) return;
        $scope.resetRowState();
    };

    $scope.getColorPresetClassName = function() {
        if ($scope.presetIndex <= 0) return '';
        return ['color-preset-', $scope.presetIndex].join('');
    };

    $scope.onPresetClick = function(index) {
        $scope.presetIndex = index;
    };

    // define what to do when a row is clicked
    $scope.onRowClick = function($event, item) {
        $event.stopPropagation();
        $scope.helpOpen = false;
        $scope.resetRowState();
        item._state.showUI = true;
    };

    // set _state.showUI to false for all row items
    $scope.resetRowState = function() {
        for (var i = 0; i < $scope.items.length; i++) {
            $scope.items[i]._state.showUI = false;
        }
    };

    // setup a sub-class to manage ui operations
    $scope.ui = (function() {

        function deactivateAll() {
            $scope.scrollElement.scrollTop = 0;
            $scope.viewActive = false;
            $scope.editActive = false;
            $scope.deleteActive = false;
        }

        return {
            activateView: function($event, item) {
                $event.stopPropagation();
                $scope.$broadcast('set-view-item', item);
                deactivateAll();
                $scope.viewActive = true;
            },
            activateEdit: function($event, item) {
                console.log('activate edit');
                $event.stopPropagation();
                $scope.$broadcast('set-edit-item', item);
                deactivateAll();
                $scope.editActive = true;
            },
            activateDelete: function($event, item) {
                $event.stopPropagation();
                deactivateAll();
                //$scope.deleteActive = true; 
            }
        };
    }());

    // generate some demo data
    (function makeExampleData() {
        for (var i = 1; i <= 100; i++) {
            $scope.items.push({
                name: ['Job Name ', i].join(''),
                company: ['Company ', i].join(''),
                client: ['Client ', i].join(''),
                status: ['Status ', i].join(''),
                _state: {
                    showUI: false
                }
            });
        }
    }());
})