Steps:

Service Side Changes:

1. Create MyService
2. Implement onBind of MyService
3. Create a  Class extending Binder Class and declare a method to return object of MyService
4. Create a Object of IBinder Class and initialize it with Object of Binder Class Created.
5. Pass the object of IBinder Class in return statement of onBind() method of MyService

Activity Side Changes:

1. Create Service Intent object
2. Start Service as usual
3. Create ServiceConnect Class object and initialize it in onCreate() method
4. In onServiceConnected() method Typecast IBinder object into Binder Class
5. Now get the MyService object from Binder Class Object

