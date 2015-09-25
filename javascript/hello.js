window.onload = function(){
   document.getElementById('button1').onclick = function(){
      showImage(document.getElementById('btn').value);
   };
}

function showImage(num){
   var htmlstr = "";

   htmlstr += "<img src='/Users/koyama/Pictures/img"+num+".jpg'>";
   document.getElementById("imageArea").innerHTML = htmlstr;
}
