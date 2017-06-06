/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//crea un elemento div con classe user che rappresenta un utente (contenuto in user)
function createElement(user){
    var img = $("<img>")
            .attr("title","profilo"+user.id)
            .attr("alt","foto profilo "+user.id)
            .attr("src",user.urlFoto);
    var link = $("<a>")
            .attr("href", "Bacheca?user="+user.id)
            .html(user.nome + " " + user.cognome);
    
    return $("<div>")
            .attr("class","user")
            .append(img)
            .append(link);
}

function stateSuccess(data){
    var userListPage = $("#contactPeople");
    
    $(userListPage).empty();
    
    var label = $("<label>")
                .html("Persone");
    
    $(userListPage).append(label);
    
    for(var instance in data){
        $(userListPage).append(createElement(data[instance]));
    }
}

function stateFailure(data, state){
    console.log(state);
}

$(document).ready(function(){
    $("#searchYourGato").click(function(){
        
        var wantedCat = $("#searchField")[0].value;
        
        $.ajax({
            url: "CercaAmiciAjax",
            data:{
                cmd:"search",
                nomeGattoCercato: wantedCat
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data);
            },
            error: function(data, state){
                stateFailure(data, state);
            }
        });
    });
});
