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
  A g;
  B () {
    f = null;
  }

  void init (boolean b) {
    g = new A();
    if (b) 
      f = new A();
  }

  void read (){
    if (g == null)
      throw new IllegalArgumentException();
  }

}

class Main {
  public static void main (String args[])
  {
    B b = new B(); 
    b.init(false);
    if (b.f != null) {
    b.f.g().h();
    b.read();
    }
  }
}
