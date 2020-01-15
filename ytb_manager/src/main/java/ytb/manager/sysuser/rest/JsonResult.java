package ytb.manager.sysuser.rest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Json 返回结果
 * @author monter
 */
@ApiModel("Json 返回结果")
public class JsonResult<T> {

	/**
	 * 是否成功
	 */
	@ApiModelProperty(name = "status", notes = "返回状态")
	private boolean status;

	@ApiModelProperty(name = "msg", notes = "完整信息")
	private String msg;

	@ApiModelProperty(name = "code", notes = "返回代码参数")
	private String code;
	/**
	 * 数据
	 */
	@ApiModelProperty(name = "data", notes = "返回参数")
	private T data;

	public boolean isSuccess() {
		return status;
	}

	public JsonResult<T> setSuccess(boolean success) {
		this.status = success;
		return this;
	}

	public JsonResult() {
	}

	private JsonResult(String code, boolean status) {
		this.code = code;
		this.status = status;
	}

	private JsonResult(String code, boolean status, T data) {
		this.code = code;
		this.status = status;
		this.data = data;
	}

	public boolean isStatus() {
		return status;
	}

	public JsonResult<T> setStatus(boolean status) {
		this.status = status;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public JsonResult<T> setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public String getCode() {
		return code;
	}

	public JsonResult<T> setCode(String code) {
		this.code = code;
		return this;
	}

	public T getData() {
		return data;
	}

	public JsonResult<T> setData(T data) {
		this.data = data;
		return this;
	}

	public static <T> JsonResult<T> success() {
		JsonResult<T> result = new JsonResult<T>("10000", true);
		return result;
	}

	public static <T> JsonResult<T> failure() {
		JsonResult<T> result = new JsonResult<T>("10001", false);
		return result;
	}

	public static <T> JsonResult<T> success(T data) {
		JsonResult<T> result = new JsonResult<T>("10000", true, data);
		return result;
	}

	public static <T> JsonResult<T> failure(T data) {
		JsonResult<T> result = new JsonResult<T>("10001", false, data);
		return result;
	}
}
