// allows us to render html tags are part of the help items (see easyHelpPopout directive below)
angular.module('angularPageApp')

.filter('renderHTMLCorrectly', function($sce) {
    return function(stringToParse) {
        return $sce.trustAsHtml(stringToParse);
    };
})