 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en" class=""><head>
      <meta charset="UTF-8">
      <link href="https://fonts.googleapis.com/css?family=DM+Sans&amp;display=swap" rel="stylesheet">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.css">
      <script src="https://code.jquery.com/jquery-3.5.0.min.js" integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ=" crossorigin="anonymous"></script>

      <link rel="stylesheet" href="/static/css/recommendation.css">

   </head>
   <body>


      <div id="root">
         <div>
            <div class="layout">
               <div class="layout_wrapper">

                  <jsp:include page="template/navbar.jsp" />

                  <div class="layout_content">
                     <div class="feed">
                        <div class="feed_header">
                           <h1 class="feed_title">Followed by my account</h1>
                        </div>

                        <%-- JSTL foreach tag varStatus example to show count in JSP  --%>
                        <c:forEach var="memberOfRecommendationArray" items="${FOLLOWED}" >
                            <div class="feed_item">
                               <div class="joke">
                                  <div class="joke_wrapper">
                                     <div class="joke_block joke_block--header">
                                        <span class="joke_element joke_element--author-name">${memberOfRecommendationArray.name}</span>
                                        <span class="joke_element joke_element--author-username">${memberOfRecommendationArray.email}</span><br>
                                        <button class="follow-member followed-button" member-id=${memberOfRecommendationArray.id} type="submit" tabindex="0" style="margin-top: 6px;">
                                            <span tabindex="-1">Followed</span>
                                        </button>
                                        <div class="joke_element joke_element--author-img">
                                            <img src="${USER_IMAGE}" >
                                        </div>
                                     </div>
                                  </div>
                               </div>
                            </div>
                        </c:forEach>



                        <div class="feed_footer">
                           <div class="pagination pagination--infinite-scroll"><button class="pagination_button_next">Load more...</button></div>
                        </div>
                     </div>
                  </div>

                  <jsp:include page="template/sidebar.jsp" />

               </div>
            </div>
         </div>
      </div>
      <script type="text/javascript" src = "/static/js/user_follow_unfollow_button_click.js"></script>
</body>
</html>