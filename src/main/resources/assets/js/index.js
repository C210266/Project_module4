$(document).ready(function () {

  const categoryData = `[
    {
      "title":"Home",
      "icon":"/img/home_active.svg",
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

  const imageList = [
    "/img/image.png",
    "/img/image1.png",
    "/img/image2.png",
  ];

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


  $(".decrease").on("click", function () {
    if ($index == 0) $index = 2;
    else $index = $index - 1;
    updateImage()
  });
  $(".increase").on("click", function () {
    if($index == 2) $index = 0;
    else $index++;
    updateImage()
  });



});