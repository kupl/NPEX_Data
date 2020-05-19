class A {
  A g() {
    return new A();
  }

  int h () {
    return 0;
  }
}

class B {
  A f;
  B () {
    f = null;
  }

  void init (boolean b) {
    if (b) 
      f = new A();
  }

  void read (){
    if (f == null)
      throw new IllegalArgumentException();
  }

}

class Main {
  public static void main (String args[])
  {
    B b = new B(); 
    b.init(false);
    b.f.g().h();
    if (b.f == null) 
      throw new IllegalArgumentException();
  }
}
