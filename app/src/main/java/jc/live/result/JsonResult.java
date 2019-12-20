package jc.live.result;



/**
 * 返回结果 
 * @Date 2018年11月6日
 */
public class JsonResult {
	
	/**
	 * 状态码
	 */
	private int code;
	/**
	 * 状态信息
	 */
	private String msg;
	/**
	 * 数据
	 */
	private Object data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static final JsonResult setReturn(final int code, final String message) {
		JsonResult ret = new JsonResult();
		ret.setCode(code);
		ret.setMsg(message);
		return ret;
	}
	
	public static final JsonResult setReturn(final String message) {
		JsonResult ret = new JsonResult();
		ret.setCode(-1);
		ret.setMsg(message);
		return ret;
	}

	public static final JsonResult setReturn(final int code, final String message, final Object data) {
		JsonResult ret = new JsonResult();
		ret.setCode(code);
		ret.setMsg(message);
		ret.setData(data);
		return ret;
	}


}
