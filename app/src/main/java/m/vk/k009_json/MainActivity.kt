package m.vk.k009_json

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getJSONObject(onCreateJSONObject())
        getJSONArray(onCreateJSONArray())
    }

    private fun onCreateJSONObject() : String{
        var jObj = JSONObject()
        jObj.put("name","Warayut Khuntongdang")
        jObj.put("nick_name","Aem")
        jObj.put("age","28")
        jObj.put("phone","0987654321")
        return jObj.toString()
    }
    private fun getJSONObject(txtJson : String){
        var jObj = JSONObject(txtJson.substring(txtJson.indexOf("{"),txtJson.lastIndexOf("}") + 1))
        tvTxtJsonObject.text = jObj.toString()
        tvNameObject.text = "ชื่อ : " + jObj.getString("name")
        tvNickNameObject.text = "ชื่อเล่น : " +  jObj.getString("nick_name")
        tvAgeObject.text = "อายุ : " +  jObj.getString("age")
        tvPhoneObject.text = "เบอร์โทร : " + jObj.getString("phone")
    }

    private fun onCreateJSONArray() : String{
        var jOb1 = JSONObject()
        jOb1.put("device","Samsung Galaxy Note9")
        jOb1.put("price","฿25,000")

        var jOb2 = JSONObject()
        jOb2.put("device","OPPO F11 Pro")
        jOb2.put("price","฿30,000")

        var jOb3 = JSONObject()
        jOb3.put("device","Google Pixel 3 XL")
        jOb3.put("price","฿28,150")

        var jArr = JSONArray()
        jArr.put(jOb1)
        jArr.put(jOb2)
        jArr.put(jOb3)

        return jArr.toString()
    }
    private fun getJSONArray(txtJson: String){
        var jObj : JSONObject
        var jArr = JSONArray(txtJson.substring(txtJson.indexOf("["),txtJson.lastIndexOf("]") + 1))
        tvTxtJsonArray.text = jArr.toString()

        for (i in 0 until jArr.length()){
            jObj = jArr.getJSONObject(i)

            when(i){
                0 -> {
                    tvDeviceJsonArray1.text = "ยี่ห่อ : ${jObj.getString("device")}"
                    tvPriceJsonArray1.text = "ราคา : ${jObj.getString("price")}"
                }
                1 -> {
                    tvDeviceJsonArray2.text = "ยี่ห่อ : ${jObj.getString("device")}"
                    tvPriceJsonArray2.text = "ราคา : ${jObj.getString("price")}"
                }
                2 -> {
                    tvDeviceJsonArray3.text = "ยี่ห่อ : ${jObj.getString("device")}"
                    tvPriceJsonArray3.text = "ราคา : ${jObj.getString("price")}"
                }
            }
        }
    }
}
