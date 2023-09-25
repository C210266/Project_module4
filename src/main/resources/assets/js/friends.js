$(document).ready(function () {

  const categoryData = `[
    {
      "title":"Home",
      "icon":"/img/home.svg",
      "link":"/home"
    },
    {
      "title":"Explore",
      "icon":"/img/explore.svg",
      "link":"/explorer"
    },
    {
      "title":"Followers",
      "icon":"/img/following.svg",
      "link":"/followers"
    },
    {
      "title":"Following",
      "icon":"/img/following.svg",
      "link":"/following"
    },
    {
      "title":"Friends",
      "icon":"/img/friends_active.svg",
      "link":"/friends"
    },
    {
      "title":"Favorite",
      "icon":"/img/favorite.svg",
      "link":"/favorite"
    }
  ]`;
  const users = `[
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
      "flag":"/img/flag_us.png"
    },
    {
      "name":"billieeilish",
      "image":"/img/man3.png",
      "location":"Billie Eilish",
      "flag":"/img/flag_eu.png"
    },
    {
      "name":"manuelneuer",
      "image":"/img/man4.png",
      "location":"Manuel Neuer",
      "flag":"/img/flag_us.png"
    },
    {
      "name":"toni.kr8s",
      "image":"/img/man5.png",
      "location":"Toni Kroos",
      "flag":"/img/flag_uk.png"
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
      "flag":"/img/flag_us.png"
    },
    {
      "name":"billieeilish",
      "image":"/img/man3.png",
      "location":"Billie Eilish",
      "flag":"/img/flag_eu.png"
    },
    {
      "name":"manuelneuer",
      "image":"/img/man4.png",
      "location":"Manuel Neuer",
      "flag":"/img/flag_us.png"
    },
    {
      "name":"toni.kr8s",
      "image":"/img/man5.png",
      "location":"Toni Kroos",
      "flag":"/img/flag_uk.png"
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
      "flag":"/img/flag_us.png"
    },
    {
      "name":"billieeilish",
      "image":"/img/man3.png",
      "location":"Billie Eilish",
      "flag":"/img/flag_eu.png"
    },
    {
      "name":"manuelneuer",
      "image":"/img/man4.png",
      "location":"Manuel Neuer",
      "flag":"/img/flag_us.png"
    },
    {
      "name":"toni.kr8s",
      "image":"/img/man5.png",
      "location":"Toni Kroos",
      "flag":"/img/flag_uk.png"
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
      "flag":"/img/flag_us.png"
    },
    {
      "name":"billieeilish",
      "image":"/img/man3.png",
      "location":"Billie Eilish",
      "flag":"/img/flag_eu.png"
    },
    {
      "name":"manuelneuer",
      "image":"/img/man4.png",
      "location":"Manuel Neuer",
      "flag":"/img/flag_us.png"
    },
    {
      "name":"toni.kr8s",
      "image":"/img/man5.png",
      "location":"Toni Kroos",
      "flag":"/img/flag_uk.png"
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
      "flag":"/img/flag_us.png"
    },
    {
      "name":"billieeilish",
      "image":"/img/man3.png",
      "location":"Billie Eilish",
      "flag":"/img/flag_eu.png"
    },
    {
      "name":"manuelneuer",
      "image":"/img/man4.png",
      "location":"Manuel Neuer",
      "flag":"/img/flag_us.png"
    },
    {
      "name":"toni.kr8s",
      "image":"/img/man5.png",
      "location":"Toni Kroos",
      "flag":"/img/flag_uk.png"
    }
  ]`

  $index = 0;
  $array = JSON.parse(categoryData);
  $html = "";
  $array.forEach((data, idx) => {
    $html +=
      '<div ><a href="' +
      data.link +
      '" class="flex gap-3 items-center cursor-pointer"><img src="';
    $html += data.icon + '" class="w-6" alt="side icon"/>';
    $html += '<span class="text-lg hover:text-red-500 text-black font-bold">';
    $html += data.title + "</span></a></div>";
  });
  $(".category-list").html($html);

  $array = JSON.parse(users);
  $html = "";
  $array.forEach((data,idx)=>{
    $html += '<div class="flex items-center justify-between gap-1"><div class="flex gap-4 items-center cursor-pointer"><img src="'
    $html += data.image + '" alt="avatar" class="w-10 h-10"><div class="flex flex-col w-full"><span class="text-black text-md font-bold">'
    $html += data.name + '</span><div class="flex gap-4 items-center"><span class="text-black text-sm">'
    $html += data.location + '</span><img src="' + data.flag + '" alt="flag" class="rounded-sm"></div></div></div><div class="flex gap-1 sm:gap-4 text-white text-xs sm:text-sm">'
    $html += '<button class="rounded-md bg-red-500 px-2 sm:px-4 md:px-8 py-1">Accept</button><button class="rounded-md border border-red-500 px-2 sm:px-4 md:px-8 py-1 text-red-500">Decline</button></div></div>'
  })

  $(".list-container").html($html);

});



