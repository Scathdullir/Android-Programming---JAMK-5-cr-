package fi.jamk.employeesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_employee.view.*
import kotlinx.android.synthetic.main.employee_item.view.*
import org.json.JSONArray
import org.json.JSONObject

class EmployeeActivity (private val employees: JSONArray) : AppCompatActivity() {

    // EmployeeActivity's onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)


        // get data from intent
        val bundle: Bundle? = intent.extras;
        if (bundle != null) {
            val employeeString = bundle!!.getString("employee")
            val employee = JSONObject(employeeString)
            val name = employee["lastName"].toString() + " " + employee["firstName"].toString()
            // modify here to display other employee's data too!
            val title = employee["title"].toString()
            val email = employee["email"].toString()
            val phone = employee["phone"].toString()
            val department = employee["department"].toString()

            Toast.makeText(this, "Name is $name",Toast.LENGTH_LONG).show()
             }
    }

    inner class ViewHolder(view: View) {
        val nameTextView: TextView = view.nameTextView2
        val titleTextView: TextView = view.titleTextView2
        val emailTextView: TextView = view.emailTextView2
        val phoneTextView: TextView = view.phoneTextView2
        val departmentTextView: TextView = view.departmentTextView2
        val imageView: ImageView = view.imageView2
    }

    // Bind data to UI View Holder
        override fun onBindViewHolder(holder: EmployeeActivity.ViewHolder, position: Int) {
        // employee to bind UI
        val employee: JSONObject = employees.getJSONObject(position)
        // employee lastname and firstname
        holder.nameTextView.text = employee["lastName"].toString() + " " + employee["firstName"].toString()
        // title, email, phone, department, image
        holder.titleTextView.text = employee["title"].toString()
        holder.emailTextView.text = employee["email"].toString()
        holder.phoneTextView.text = employee["phone"].toString()
        holder.departmentTextView.text = employee["department"].toString()
        // to get context in Glide, you can use holder.imageView.context
        Glide.with(holder.imageView.context).load(employee["image"]).into(holder.imageView)
    }

}
