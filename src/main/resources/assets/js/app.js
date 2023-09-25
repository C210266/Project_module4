$(document).ready(function () {
  const people = `[
    {
      "name":"Willsmith",
      "image":"/img/man1.png",
      "location":"Willsmith",
      "flag":"/img/flag_ca.png"
    },
    {
      "name":"edshreean",
      "image":"/img/man2.png",
      "location":"Ed Sheeran",
      "flag":"/img/flag_eu.png"
    },
    {
      "name":"Willsmith",
      "image":"/img/man3.png",
      "location":"Willsmith",
      "flag":"/img/flag_uk.png"
    },
    {
      "name":"Willsmith",
      "image":"/img/man4.png",
      "location":"Willsmith",
      "flag":"/img/flag_us.png"
    },
    {
      "name":"Willsmith",
      "image":"/img/man1.png",
      "location":"Willsmith",
      "flag":"/img/flag_ca.png"
    },
    {
      "name":"edshreean",
      "image":"/img/man2.png",
      "location":"Ed Sheeran",
      "flag":"/img/flag_eu.png"
    },
    {
      "name":"Willsmith",
      "image":"/img/man3.png",
      "location":"Willsmith",
      "flag":"/img/flag_uk.png"
    },
    {
      "name":"Willsmith",
      "image":"/img/man4.png",
      "location":"Willsmith",
      "flag":"/img/flag_us.png"
    }
  ]`;


  let mobileMenu = false;
  $index = 0;
  $array = JSON.parse(people);
  $html = "";
  $array.forEach((data) => {
    $html += '<div class="flex gap-4 items-center cursor-pointer"><a href="/profile" class="w-12 h-12 flex items-center"><img src="';
    $html += data.image + '" alt="avatar" /></a>';
    $html +=
      '<div class="flex flex-col w-full"><span class="text-black text-xl">';
    $html +=
      data.name +
      '</span><div class="flex gap-4 items-center"><span class="text-black text-sm">';
    $html += data.location + '</span><img src="';
    $html += data.flag;
    $html += '" alt="flag" class="rounded-sm"/></div></div></div>';
  });
  $("#user-list").html($html);

  $(".menu-button").on("click", function(){
    mobileMenu = !mobileMenu;
    $("#menu-icon").attr("src",!mobileMenu?"/img/menu.svg":"/img/close.svg")
    toggleMobileMenu()
  })
  
  function toggleMobileMenu(){
    mobileMenu?$("#menu-mobile").css("display","flex"):$("#menu-mobile").hide()
  }
  function updateImage(){
    $("#frame").attr("src",imageList[$index]);
  }

  let menuopen = false

  $(".btn-menu").on("click", function(){
    menuopen = !menuopen
    if(menuopen){
      $(".toggle-menu").removeClass("hidden")
      $(".icon-menu").attr("src","/img/icons/angle_up.svg")
    }
    else{
      $(".toggle-menu").addClass("hidden")
      $(".icon-menu").attr("src","/img/icons/angle_down.svg")
    }
  })
});
