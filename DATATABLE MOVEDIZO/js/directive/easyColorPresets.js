angular.module('angularPageApp')

.directive('easyColorPresets', function() {
    return {
        restrict: 'E',
        replace: true,
        template: [
            '<div class="color-presets flex" ng-class="{open: presetsOpen === true}">',
            '<div class="preset-toggle hint--right" data-hint="Table Color">',
            '<span class="fa-stack" ng-click="presetsOpen = !presetsOpen">',
            '<i class="fa fa-square-o fa-stack-2x"></i>',
            '<i class="fa fa-paint-brush fa-stack-1x"></i>',
            '</span>',
            '</div>',
            '<div class="color-preset" ng-repeat="preset in colorPresets">',
            '<div class="color-box" style="background-color: {{ preset }}" ng-click="onPresetClick($index + 1);"></div>',
            '</div>',
            '</div>'
        ].join('')
    };
})
