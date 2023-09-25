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
      "icon":"/img/friends.svg",
      "link":"/friends"
    },
    {
      "title":"Favorite",
      "icon":"/img/favorite.svg",
      "link":"/favorite"
    }
  ]`;

  // const postsData = `[
  //   {
  //     "image":"/img/post1.png"
  //   },
  //   {
  //     "image":"/img/post2.png"
  //   },
  //   {
  //     "image":"/img/post3.png"
  //   },
  //   {
  //     "image":"/img/post4.png"
  //   },
  //   {
  //     "image":"/img/post5.png"
  //   },
  //   {
  //     "image":"/img/post6.png"
  //   }
  // ]`

  const storyData = `[
    {
      "name":"Story 1",
      "image":"/img/story1.png"
    },
    {
      "name":"Story 2",
      "image":"/img/story2.png"
    },
    {
      "name":"Story 3",
      "image":"/img/story3.png"
    },
    {
      "name":"Story 4",
      "image":"/img/story4.png"
    },
    {
      "name":"Story 5",
      "image":"/img/story5.png"
    },
    {
      "name":"Story 6",
      "image":"/img/story6.png"
    },
    {
      "name":"Story 7",
      "image":"/img/story7.png"
    }
  ]`

  const suggestData = `[
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

  let limit = 4;

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

  // $array = JSON.parse(postsData);
  // $html = "";
  // $array.forEach((data, idx) => {
  //   $html += '<img src="'+ data.image+'" alt="post"  class="w-full"/>'
  // });
  // $(".box-posts").html($html);

  $array = JSON.parse(storyData);
  $html = "";
  $array.forEach((data, idx) => {
    $html += '<div class="inline-block snap-start text-center mr-4"><img src="'+ data.image+'" alt="story"/><span class="text-sm font-bold">'
    $html += data.name + '</span></div>'
  });
  $(".box-story").html($html);



  $(".btn-see-all").on("click", function(){
    limit = 999;
    drawSuggest()
  })

  function drawSuggest(){
    $array = JSON.parse(suggestData);
    $html = "";
    $array.forEach((data, idx) => {
      if(idx<limit){
      $html += '<div class="border pt-4 relative rounded-md w-40 inline-block snap-start mr-4"><button class="absolute top-2 right-2">'
      $html += '<img src="/img/icons/ic_close.svg" alt="close icon" /></button><div class="flex flex-col items-center justify-center px-2 py-5 gap-4"><img src="'
      $html += data.image + '" alt="user img" /><div class="flex flex-col items-center justify-center"><span class="font-bold text-sm">'
      $html += data.name + '</span><div class="flex items-center gap-2 "><span class="text-xs">' + data.location + '</span><img src="' + data.flag + '" alt="flag" />'
      $html += '</div></div><button class="w-full rounded-md bg-red-500 text-center text-white font-bold text-md py-1">Follow</button></div></div>'
      }
    });
    $(".box-suggest").html($html);
  }

  drawSuggest()
});