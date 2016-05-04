angular.module('bucketList.services', ['firebase']
)
  .factory('Auth',['$firebaseAuth',function($firebaseAuth) {
      var rootRef = new Firebase('https://poojasavernsavior.firebaseio.com/');
    return $firebaseAuth(rootRef);
  }])

