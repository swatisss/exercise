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
