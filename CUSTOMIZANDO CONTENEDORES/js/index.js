angular.module("angularPageApp", [])

angular.module('angularPageApp')

    .service("elencoCitta", function() { 
        this.elenco  = [ 
            {nome: "Roma", regione: "Lazio"}, 
            {nome: "Latina", regione: "Lazio"}, 
            {nome: "Milano", regione: "Lombardia"}, 
            {nome: "Napoli", regione: "Campania"}, 
            {nome: "Como", regione: "Lombardia"}, 
            {nome:"Palermo", regione: "Sicilia"}, 
            {nome: "Caserta", regione: "Campania"}, 
            {nome: "Avellino", regione: "Campania"}, 
            {nome:"Trapani", regione: "Sicilia"}, 
            {nome:"Agrigento", regione: "Sicilia"} 
        ]; 
         
        this.aggiungi = function(citta) { 
            this.elenco.push(citta); 
        }; 
    })

    .service("contenedores", function() { 
        this.contenedores  = [ 
            {color: "red", posicion: "1",}, 
            {color: "blue", posicion: "2"}, 
            {color: "black", posicion: "3"}, 
            {color: "green", posicion: "4"}
            
        ];         
        
    })


    .controller("elencoController", function($scope, elencoCitta) { 
        $scope.elencoCitta = elencoCitta.elenco; 
    })

    .controller("cittaController", function($scope, elencoCitta) { 
        $scope.aggiungiCitta = function() { 
            elencoCitta.aggiungi({nome: $scope.nome, regione: $scope.regione}); 
        }; 
    })

    .controller("containerController",   
        function($scope) { 



        $scope.contenedores  = [ 

            {id:"id-01" ,color: "red", posicion: "1", descripcion: "Caja de texto común", estilo:{backgroundColor:"red",fontSize:"12px",height:"50%",width:"50%",border:"1px solid",borderColor:"blue"}}, 
            {id:"id-02" ,color: "blue", posicion: "2", descripcion: "Caja de texto cabecera",estilo:{backgroundColor:"red",fontSize:"12px",height:"50%",width:"50%",border:"1px solid",borderColor:"blue"}}, 
            {id:"id-03" ,color: "black", posicion: "3", descripcion: "Caja de texto promociones",estilo:{backgroundColor:"red",fontSize:"12px",height:"50%",width:"50%",border:"1px solid",borderColor:"blue"}}, 
            {id:"id-04" ,color: "green", posicion: "4", descripcion: "Caja de texto para imágenes",estilo:{backgroundColor:"red",fontSize:"12px",height:"50%",width:"50%",border:"1px solid",borderColor:"blue"}}
            
        ]; 

    
      $scope.estilos  = [

            {elemento:"e-01", plantilla:"pl-01",id:"id-01" ,backgroundColor:"red",fontSize:"12px",height:"50%",width:"50%",border:"1px solid",borderColor:"blue"},
            {elemento:"e-02", plantilla:"pl-01",id:"id-02" ,backgroundColor:"blue",fontSize:"12px",height:"50%",width:"50%",border:"1px solid",borderColor:"blue"},
            {elemento:"e-03", plantilla:"pl-01",id:"id-03" ,backgroundColor:"green",fontSize:"12px",height:"50%",width:"50%",border:"1px solid",borderColor:"blue"},
            {elemento:"e-01", plantilla:"pl-02",id:"id-04" ,backgroundColor:"black",fontSize:"12px",height:"50%",width:"50%",border:"1px solid",borderColor:"blue"}

        ];

   
    $scope.getBackgroundColor = function(contenedor){

      var colorBk = $scope.estilos;
      var color="red";
        
        colorBk.forEach(function(data)
        {
           if(contenedor.id===data.id){                   
                color = data.backgroundColor;

                 console.log('se encontraron ids iguales; contenedor : '+ contenedor.id + " ; data : " + data.id+ ' ; color ' + color);  

                return color;                
            }           
        });


      return color;
    };


    })

    .directive('colorPicker', function() {

var colorList = [ '000000', '993300', '333300', '003300', '003366', '000066', '333399', '333333', 
'660000', 'FF6633', '666633', '336633', '336666', '0066FF', '666699', '666666', 'CC3333', 'FF9933', '99CC33', '669966', '66CCCC', '3366FF', '663366', '999999', 'CC66FF', 'FFCC33', 'FFFF66', '99FF66', '99CCCC', '66CCFF', '993366', 'CCCCCC', 'FF99CC', 'FFCC99', 'FFFF99', 'CCffCC', 'CCFFff', '99CCFF', 'CC99FF', 'FFFFFF' ];

   var picker = $('#color-picker');

        for (var i = 0; i < colorList.length; i++ ) {
            picker.append('<li class="color-item" data-hex="' + '#' + colorList[i] + '" style="background-color:' + '#' + colorList[i] + ';"></li>');
        }

        $('body').click(function () {
            picker.fadeOut();
        });

        $('.call-picker').click(function(event) {
            event.stopPropagation();
            picker.fadeIn();
            picker.children('li').hover(function() {
                var codeHex = $(this).data('hex');

                $('.color-holder').css('background-color', codeHex);
                $('#pickcolor').val(codeHex);
            });
        });

    return {
       
        restrict: 'E',
        replace: true,
        template : [
        '<div class="color-wrapper">',
        '<p>Choose color (# hex)</p>',
        '<input type="text" name="custom_color" placeholder="#FFFFFF" id="pickcolor" class="call-picker">',
        '<div class="color-holder call-picker"></div>',
        '<div class="color-picker" id="color-picker" style="display: none"></div>',
        '</div>'

        ].join('')

    };


})







