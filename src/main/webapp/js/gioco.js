class Gioco{
    constructor(nome,nazione,idGames){
         this.nome;
         this.nazione;
         this.idGames;
    }




infoTeam(){
    return "<p>Nome: "+this.titolo +"</p>"+
             "<p>Nazione: "+this.nazione+"</p>"+
             "<p>idGames: "+this.idGames+"</p>";
}

}

function renderInfoTeam(team){
    document.getElementById('modaleInfoTeam').style.display='block';
    document.getElementById('mod-id').value= game.getAttribute('data-id');
    document.getElementById('mod-nome').value= game.getAttribute('data-nome');
    document.getElementById('mod-nazione').value= game.getAttribute('data-nazione');
    document.getElementById('mod-idGames').value= game.getAttribute('data-idGames');
}

function pulisciNewTeam(){
    for(let input of document.querySelectorAll("#modaleInfoTeam> .modal-content > input")){
        input.value="";
    }
    document.querySelector("#modaleNewTeam > .modal-content> select").value="";
}

function pulisciModaleTeam(){
    for(let input of document.querySelectorAll("#modaleInfoTeam> .modal-content > input")){
        input.value="";
    }
    document.querySelector("#modaleInfoTeam >.modal-content> select").value="";
}

function inizio(){
    
    document.getElementById("bottoneNewTeam").onclick=function(){
        document.getElementById('modaleNewTeam').style.display='block';
    }
    document.getElementById("chiudiModaleInfo").onclick=function(){
        document.getElementById("modaleInfoTeam").style.display='none';
    }
    document.getElementById("chiudiModaleNew").onclick=function(){
        document.getElementById("modaleNewTeam").style.display='none';
    }
    render();
    
   
}