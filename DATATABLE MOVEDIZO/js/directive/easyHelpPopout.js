angular.module('angularPageApp')

.directive('easyHelpPopout', function() {
    return {
        restrict: 'E',
        replace: true,
        template: [
            '<div class="help-popout" ng-class="{open: helpOpen === true}">',
            '<div class="help-toggle hint--left" data-hint="Help">',
            '<span class="fa-stack" ng-click="$event.stopPropagation(); helpOpen = !helpOpen">',
            '<i class="fa fa-circle-thin fa-stack-2x"></i>',
            '<i class="fa fa-question fa-stack-1x"></i>',
            '</span>',
            '</div>',
            '<div class="help-items" ng-click="$event.stopPropagation();">',
            '<div class="help-item" ng-repeat="item in helpItems">',
            '<div class="help-item-number">{{ $index + 1 }}</div>',
            '<div class="help-box" ng-bind-html="item | renderHTMLCorrectly"></div>',
            '</div>',
            '</div>',
            '</div>'
        ].join('')
    };
})