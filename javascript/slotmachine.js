   var timers,
         nums,
    stopCount;

    function startSlot(){
      timers = [];
      nums = [];
      stopCount = 0;

      runSlot(0);
      runSlot(1);
      runSlot(2);
   };

   document.getElementById('stop0').onclick = function(){
      stopSlot(0);
   };

   document.getElementById('stop1').onclick = function(){
      stopSlot(1);
   };

   document.getElementById('stop2').onclick = function(){
      stopSlot(2);
   };


function runSlot(n){
   document.getElementById('num'+n).innerHTML = Math.floor(Math.random() * 10);
   timers[n] = setTimeout(function(){
      runSlot(n);
   }, 50);
}


function stopSlot(n){
   clearTimeout(timers[n]);
   console.log(n);
   // ここで、TypeErrorがでるのはなぜ？
   nums[n] = document.getElementById('num'+n).innerHTML;
   stopCount++;

   if(stopCount == 3){
      checkSlot();
   }
}

function checkSlot(){
   alert("check");
}
