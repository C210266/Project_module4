$(document).ready(function () {


  const users = `[
    {
      "name":"Willsmith",
      "image":"/img/man1.png",
      "location":"Willsmith",
      "flag":"/img/flag_ca.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"edshreean",
      "image":"/img/man2.png",
      "location":"Ed Sheeran",
      "flag":"/img/flag_us.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"billieeilish",
      "image":"/img/man3.png",
      "location":"Billie Eilish",
      "flag":"/img/flag_eu.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"manuelneuer",
      "image":"/img/man4.png",
      "location":"Manuel Neuer",
      "flag":"/img/flag_us.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"toni.kr8s",
      "image":"/img/man5.png",
      "location":"Toni Kroos",
      "flag":"/img/flag_uk.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"Willsmith",
      "image":"/img/man1.png",
      "location":"Willsmith",
      "flag":"/img/flag_ca.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"edshreean",
      "image":"/img/man2.png",
      "location":"Ed Sheeran",
      "flag":"/img/flag_us.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"billieeilish",
      "image":"/img/man3.png",
      "location":"Billie Eilish",
      "flag":"/img/flag_eu.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"manuelneuer",
      "image":"/img/man4.png",
      "location":"Manuel Neuer",
      "flag":"/img/flag_us.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"toni.kr8s",
      "image":"/img/man5.png",
      "location":"Toni Kroos",
      "flag":"/img/flag_uk.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"Willsmith",
      "image":"/img/man1.png",
      "location":"Willsmith",
      "flag":"/img/flag_ca.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"edshreean",
      "image":"/img/man2.png",
      "location":"Ed Sheeran",
      "flag":"/img/flag_us.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"billieeilish",
      "image":"/img/man3.png",
      "location":"Billie Eilish",
      "flag":"/img/flag_eu.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"manuelneuer",
      "image":"/img/man4.png",
      "location":"Manuel Neuer",
      "flag":"/img/flag_us.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"toni.kr8s",
      "image":"/img/man5.png",
      "location":"Toni Kroos",
      "flag":"/img/flag_uk.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"Willsmith",
      "image":"/img/man1.png",
      "location":"Willsmith",
      "flag":"/img/flag_ca.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"edshreean",
      "image":"/img/man2.png",
      "location":"Ed Sheeran",
      "flag":"/img/flag_us.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"billieeilish",
      "image":"/img/man3.png",
      "location":"Billie Eilish",
      "flag":"/img/flag_eu.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"manuelneuer",
      "image":"/img/man4.png",
      "location":"Manuel Neuer",
      "flag":"/img/flag_us.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"toni.kr8s",
      "image":"/img/man5.png",
      "location":"Toni Kroos",
      "flag":"/img/flag_uk.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"Willsmith",
      "image":"/img/man1.png",
      "location":"Willsmith",
      "flag":"/img/flag_ca.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"edshreean",
      "image":"/img/man2.png",
      "location":"Ed Sheeran",
      "flag":"/img/flag_us.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"billieeilish",
      "image":"/img/man3.png",
      "location":"Billie Eilish",
      "flag":"/img/flag_eu.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"manuelneuer",
      "image":"/img/man4.png",
      "location":"Manuel Neuer",
      "flag":"/img/flag_us.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    },
    {
      "name":"toni.kr8s",
      "image":"/img/man5.png",
      "location":"Toni Kroos",
      "flag":"/img/flag_uk.png",
      "type":"new",
      "content":"new notification",
      "time":"3 hours ago"
    }
  ]`

  $array = JSON.parse(users);
  $html = "";
  let rand = 0;
  $array.forEach((data,idx)=>{
    rand = parseInt(Math.random()*10%5)
    $html += '<div class="flex py-2 justify-between items-center px-2 sm:mx-8"><div class="flex items-center gap-4"><img src="'
    $html += data.image + '" alt="user avatar"/><div class="flex flex-col"><p class="text-sm font-bold">'
    $html += data.name + '<span class="font-normal"> '+ data.content + '</span></p><span class="text-sm">'
    $html += data.time + '</span></div></div>'
    if(idx<3){
      $html += '<button><img src="/img/icons/badge_new.svg" alt="notif icon" />'
    }
    else if(idx%(rand) == 0){
      $html += '<button class="px-2 sm:px-8 py-2 border-red-500 border rounded-md text-xs sm:text-sm font-bold text-red-500">Follow'
    }
    else if(idx%(rand) == 1){
      $html += '<button><img src="/img/icons/ic_video.svg" alt="notif icon" />'
    }
    else{
      $html += '<button>'
    }
    $html += '</button></div>'
  })

  $(".box-notification").html($html);

});