//function showNewsHandling(){
//    var news = document.getElementById("news-list");
//    console.log(news.getElementsByTagName("li")[0]).innerHTML;
//}
//showNewsHandling();
//
//function changeHeading(){
//    var news = document.getElementById("news");
//    news.innerHTML="Wesołe newsy";
//    var sport = document.getElementById("sport");
//    sport.innerHTML= "Anty sport"
//}
//
//setTimeout(changeHeading, 3000);

function addNews(){
    var ul = document.getElementById("news-list");
    var input = document.getElementById("input-text");
    var newsText = input.value;
    var li = document.createElement("li");
    var liText = document.createTextNode(newsText);
    li.appendChild(liText);
    ul.appendChild(li);
    input.value = "";
}

function registeEvents(){
    var button = document.getElementById("add-button");
    button.onclick = function(){
        addNews();
    }
}
registeEvents();