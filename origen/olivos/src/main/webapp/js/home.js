var modules = document.querySelectorAll('[data-module="open"]');

for (var i = 0; i < modules.length; i++) {
  modules[i].addEventListener('click', function(event) {
   var elem = event.currentTarget.parentElement;

   if (elem.classList.contains('open')) {
    elem.classList.remove('open');
   } else {
    elem.classList.add('open');
   }
 });
}

var form = document.querySelector('.psuedo-dropdown');
form.addEventListener('click', function(event) {
  window.scrollTo(0,document.body.scrollHeight);
})