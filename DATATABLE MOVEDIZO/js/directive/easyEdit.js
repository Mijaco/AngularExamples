angular.module('angularPageApp')

.directive('easyEdit', function() {
    return {
        restrict: 'E',
        replace: true,
        template: [
            '<div class="expando-edit">',
            '<div class="expando-row no-scale">',
            '<div class="data-cell">{{ item.name }}</div>',
            '<div class="data-cell">{{ item.company }}</div>',
            '<div class="data-cell">{{ item.client }}</div>',
            '<div class="data-cell">{{ item.status }}</div>',
            '<div class="open-view hint--right" data-hint="View" ng-click="ui.activateView($event, item)"><i class="fa fa-external-link"></i></div>',
            '<div class="close-edit hint--right" data-hint="Close" ng-click="$event.stopPropagation(); editActive = false;"><i class="fa fa-times"></i></div>',
            '</div>',
            '<div class="edit-content">',
            '<p>Edit Content</p>',
            '</div>',
            '</div>'
        ].join(''),
        link: function(scope, element, attrs) {
            scope.$on('set-edit-item', function(event, editItem) {
                scope.item = editItem;
            });
        }
    };
})