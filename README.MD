Sample example of RxJava2 
 1. This sample contains two long running service (simulated by Thread.sleep)
 
    a) VideoService
     
    b) RatingService
   
 2. getAllRatings and getAllVideos runs asynchronously in two different thread.
 3. The main thread zip both rating and videos converts to VideoRating and return to caller.