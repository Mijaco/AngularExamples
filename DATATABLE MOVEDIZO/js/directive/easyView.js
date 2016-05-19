angular.module('angularPageApp')

.directive('easyView', function($timeout) {
    return {
        restrict: 'E',
        replace: true,
        template: [
            '<div class="expando-view">',
            '<div class="expando-row no-scale">',
            '<div class="data-cell">{{ item.name }}</div>',
            '<div class="data-cell">{{ item.company }}</div>',
            '<div class="data-cell">{{ item.client }}</div>',
            '<div class="data-cell">{{ item.status }}</div>',
            '<div class="open-edit hint--right" data-hint="Edit" ng-click="ui.activateEdit($event, item)"><i class="fa fa-pencil"></i></div>',
            '<div class="close-view hint--right" data-hint="Close" ng-click="$event.stopPropagation(); viewActive = false;"><i class="fa fa-times"></i></div>',
            '</div>',
            '<div class="view-content">',
            '<p>View Content</p>',
            '</div>',
            '</div>'
        ].join(''),
        link: function(scope, element, attrs) {
            scope.$on('set-view-item', function(event, viewItem) {
                scope.item = viewItem;
            });
        }
    };
})
