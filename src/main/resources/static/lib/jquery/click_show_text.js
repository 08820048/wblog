var a_idx = 0;
jQuery(document).ready(function($) {
    $("body").click(function(e) {
        var a = new Array
        ("排除一切不可能的，剩下的即使再不可能，那也是真相","重要的是，你如何使别人相信你做了些什么"," " +
            "我从不猜测，那是破坏思维能力的坏习惯","没有什么比一个显而易见的事实更能迷惑人了",
            "不要让一个人的外表影响你的判断力，这是最重要的。感情会影响理智",
            "猜想是很不好的习惯，它有害于作逻辑的推理",
            "我已经等了他十年，再等十年又有什么关系呢",
            "我想是遇见了不该遇见的人，大概是情人吧",
            "真相只有一个",
            "深海里的鲨鱼，看到海面上、阳光下跳跃的海豚，总会不自觉的害怕",
            "人是不能阻止时间流逝的，如果硬是要逆天而行的话，就会收到惩罚",
            "在这种情况下要做好心理准备,这场赌博你并没有胜算",
            "只要和你有关的任何事情我都不会忘记。",
            "她是我在这个世界上最不愿失去的人",
            "新一……我以为你不见了，你又突然出现了",
            "因为,因为我喜欢你!比地球上任何一个人都要喜欢你",
            "我似乎觉得，新一渐渐远去了，似乎去了很远的地方"

            );
        var $i = $("<span/>").text(a[a_idx]);
        a_idx = (a_idx + 1) % a.length;
        var x = e.pageX,
            y = e.pageY;
        $i.css({
            "z-index": 5,
            "top": y - 20,
            "left": x,
            "position": "absolute",
            "font-weight": "bold",
            "color": "rgb(" + ~~(255 * Math.random()) + "," + ~~(255 * Math.random()) + "," + ~~(255 * Math.random()) + ")"

        });
        $("body").append($i);
        $i.animate({
                "top": y - 180,
                "opacity": 0
            },
            3000,
            function() {
                $i.remove();
            });
    });
    setTimeout('delay()', 2000);
});

function delay() {
    $(".buryit").removeAttr("onclick");
}
