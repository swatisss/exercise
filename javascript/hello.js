$(function(){
   var tablerow = $("tr");
   tablerow.filter(":first").text("あわわ");
   // alert(tablerow.filter(":first").text());

   $('#msg2').attr("value","おやすみ");
   console.log($('tr~').html());

   // $('img').attr('src','C:\\Users\\koyama\\Pictures\\img4.jpg');

   tablerow.filter(":first").addClass('highlight');
   // tablerow.filter(":first").removeClass("large");
   $('#fruits')
      .append("<li>パイナップル</li>")
      .prepend("<li>なし</li>")
      .before("<p>おいしいよ</p>")
      .after("<p>購入はこちら!</p>")
      .empty();

   $('#cli').on('click',function(){
      alert("やあ");
   });
});

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

// 即時関数を使う
// クロージャで内部の変数にiを保持しておく
for(var i = 0; i < 3; i++){
   document.getElementById("rd_"+i).onclick = (function(cnt){
      return function(){
         alert(cnt);
      };
   })(i);
}
//保持されたiが012と表示される
