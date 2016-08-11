// Popup Open
function popupOpen(indice){
//	alert("Esta página está en construcción, gracias por su compresión");
	
	var idPopup = "popup"+indice;
	var idOverlay = "overlay"+indice;
    document.getElementById("popup").style.display="block";
    document.getElementById("overlay").style.display="block";
    
    var parrafoPopupObject = document.getElementById("idParrafoPopup");
    var headerPopupObject = document.getElementById("idHeaderPopup");
    if(indice==0){
    	
    	headerPopupObject.innerHTML = "Mysql";
    	parrafoPopupObject.innerHTML = "Queries, Funciones, Uso del modelador del Workbench 5.2  ";
    	
    	
    }else if(indice==1){
    	headerPopupObject.innerHTML = "SQL Server";
    	parrafoPopupObject.innerHTML = "Queries, Funciones, Store Procedures, Punteros ,Triggers , Transact - SQL , uso del SQL Server Managament Studio";
    	
    }else if(indice==2){
    	headerPopupObject.innerHTML = "Oracle";
    	parrafoPopupObject.innerHTML = "Creación de índices, Tunning de queries con uso del Jdeveloper";
    }
    
    
	}
// Popup Close
	function popupClose(){
    document.getElementById("popup").style.display="none";
    document.getElementById("overlay").style.display="none";
	}