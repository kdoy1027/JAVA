package ch13;

class AA {
	BB b = new BB();
	public void atest() throws Exception{
		b.test();
	}
};


class BB {
	public void test() throws Exception{
		throw new Exception ("예외 강제 발생");
	
}


public static class IoExceptionError {
	
	public static void main(String[] args) {
		AA a = new AA();
		try {
			a.atest();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("수고하셨습니다리");
		}
	}

	}
}
