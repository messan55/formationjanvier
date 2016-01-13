$(document).ready(function() {
    
   $("#contenu1").hide();
   var elem2 = $('#bouton1');
   elem2.click(MYLIB.requetteJSON);
});

var MYLIB = {};

MYLIB.requetteJSON = function() {
  var elem = $('#contenu1');
  elem.empty().hide();
  $.getJSON('../rest/tache', function(data) {
      elem.append("<h2>liste des taches</h2>");
      var ulelem = $("<ul></ul>")
      elem.append(ulelem);
      $(data.taches).each(function(idx) {
          ulelem.append("<li>" + data.taches[idx].libelle + "</li>");
      });
      elem.slideDown(1000);
  });
}