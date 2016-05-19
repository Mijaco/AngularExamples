angular.module('angularPageApp')

.directive('easyTable', function($timeout) {
    return {
        restrict: 'E',
        template: [
            '<div class="expando-table" ng-class="{\'view-active\': viewActive === true, \'edit-active\': editActive == true}">',
            '<div class="expando-header">',
            
            '</div>',
            '<div class="expando-rows">',
            '<div class="expando-row" ng-repeat="item in items" ',
            'ng-class="{showUI: item._state.showUI === true}" ',
            'ng-click="onRowClick($event, item)">',
            '<div class="popout-ui">',
            '<div class="row-actions flex-center">',
            '<div class="row-action close ng-hide" ng-click="resetRowState()"><i class="fa fa-times"></i></div>',
            '<div class="row-action view" ng-class="{\'hint--bottom\': $index <= 1, \'hint--top\': $index > 0}" data-hint="View" ng-click="ui.activateView($event, item)"><i class="fa fa-external-link"></i></div>',
            '<div class="row-action edit" ng-class="{\'hint--bottom\': $index <= 1, \'hint--top\': $index > 0}" data-hint="Edit" ng-click="ui.activateEdit($event, item)"><i class="fa fa-pencil"></i></div>',
            '<div class="row-action delete" ng-class="{\'hint--bottom\': $index <= 1, \'hint--top\': $index > 0}" data-hint="Delete" ng-click="ui.activateDelete($event, item)""><i class="fa fa-trash"></i></div>',
            '</div>',
            '</div>',
            '<div class="click-indicator"><i class="fa fa-arrow-right"></i></div>',
            '<div class="data-cell">{{ item.name }}</div>',
            '<div class="data-cell">{{ item.company }}</div>',
            '<div class="data-cell">{{ item.client }}</div>',
            '<div class="data-cell">{{ item.status }}</div>',
            '</div>',
            '</div>',
            '<easy-view></easy-view>',
            '<easy-edit></easy-edit>',
            '</div>'
        ].join(''),
        link: function(scope, element, attrs) {
            scope.scrollElement = element[0].querySelector('.expando-table');
        }
    };
})

