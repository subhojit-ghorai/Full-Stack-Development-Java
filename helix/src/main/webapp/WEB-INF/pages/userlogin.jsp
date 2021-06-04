<html>
<body>
USER LOGIN

<div id = "time">
</div>

<br>
<br>

<div>
<marquee>Made by Subhojit Ghorai</marquee>
</div>

<script type = "text/javascript">
function updateTime()
{
    document.getElementById("time").innerText = new Date().toString();
}

setInterval(updateTime,1000)

</script>
</body>
</html>