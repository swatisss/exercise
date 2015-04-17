
var e = document.getElementById('msg');
e.textContent = 'Hello!';
e.style.color = "Blue";
e.className = 'mystyle';

var ans = confirm("OK?");

if(ans == true){
    alert("thank you!");
}else{
    alert("Sorry...");
}

document.getElementById("add").addEventListener("click", function(){
    var greet = document.createElement("p");
    var text = document.createTextNode("Hello,World");
    document.body.appendChild(greet).appendChild(text);

});
