class Game{
    constructor(titolo){
        this.titolo=titolo;
    }


listaItem(){
    return "<li onclick=\"renderInfoGioco('"+this.titolo +"')\">"+ this.titolo +"</li>";
}

infoGioco(){
    return "<p>Titolo: "+this.titolo +"<p>";
}

}


function renderInfoGioco(game){
    document.getElementById('modaleInfoGame').style.display='block';
    document.getElementById('mod-id').value= game.getAttribute('data-id');
    document.getElementById('mod-titolo').value= game.getAttribute('data-titolo');
}

function pulisciNewGame(){
	
    for(let input of document.querySelectorAll("#modaleInfoGame> .modal-content > input")){
        input.value="";
    }
    document.querySelector("#modaleNewGame > .modal-content> select").value="";
}

function pulisciModaleGame(){
    for(let input of document.querySelectorAll("#modaleInfoGame> .modal-content > input")){
        input.value="";
    }
    document.querySelector("#modaleInfoGame >.modal-content> select").value="";
}

function inizio(){
    document.getElementById("bottoneNewGame").onclick=function(){
        document.getElementById("modaleNewGame").style.display='block';
    }
    document.getElementById("chiudiModaleInfo").onclick=function(){
        document.getElementById("modaleInfoGame").style.display='none';
    }
    document.getElementById("chiudiModaleNew").onclick=function(){
        document.getElementById("modaleNewGame").style.display='none';
    }
rendereListGame();
}