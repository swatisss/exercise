function sayHello(){
   var htmlstring = "tes"
   var elem = document.createElement("p");
   elem.textContent = htmlstring;
   document.getElementById("p").appendChild(elem);
}

window.onload = function(){
   document.getElementById("button1").onclick = sayHello;
};
