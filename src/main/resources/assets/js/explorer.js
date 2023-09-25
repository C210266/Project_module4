$(document).ready(function () {
    const categoryData = `[
    {
      "title":"Home",
      "icon":"/img/home.svg",
  "link":"/home"
    },
    {
      "title":"Explore",
      "icon":"/img/ico_explorer_active.svg",
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
});
