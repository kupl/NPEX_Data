class D {
  int data;
}

class C {
  int data;
  public D h() {
    D ret = new D();
    ret.data = this.data;
    return ret;
  }
}
class B {
  int data;
  public C g() {
    C ret = new C();
    ret.data = this.data;
    return ret;
  }
}

class A {
  int data;
  public B f() {
    B ret = new B();
    ret.data = this.data;
    return ret;
  }
}

class X {
  int data;
  public A null_src(boolean b) {
    if (b)
      return null;
    else
      return new A();
  }
  public void store(D d) {
    this.data = d.data;
  }
  public void print() {
    System.out.println("HIHI");
  }
}



class Main {
  public static void main (String args[])
  {
    X x = new X();
    A a = x.null_src(true);
    B b = a.f();
    C c = b.g();
    D d = c.h();
    
    x.store(d);
    x.print();
  }
}


