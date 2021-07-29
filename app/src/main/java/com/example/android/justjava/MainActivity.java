package com.example.android.justjava;

/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    //global variables
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     * Make sure submitOrder method is public type
     */

    public void submitOrder(View view) {
        CheckBox checkBoxCream = (CheckBox) findViewById(R.id.cream_checkbox);
        boolean hasWhippedCream = checkBoxCream.isChecked();

        CheckBox checkBoxChocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = checkBoxChocolate.isChecked();

        TextView nameView = (TextView) findViewById(R.id.text_input_name);
        String inputName = nameView.getText().toString();

        int price = calculatePrice();
        String message = createOrderSummary(inputName,price,hasWhippedCream,hasChocolate);
        displayMessage(message);
    }

    private int calculatePrice() {
        int price = quantity * 5 ;
        return price;
    }

    /**
     * Create summary of the order.
     *
     * @param price           of the order
     * @param addWhippedCream is whether or not to add whipped cream to the coffee
     * @param addChocolate    is whether or not to add chocolate to the coffee
     * @return text summary
     */

    private String createOrderSummary(String nameText, int price , boolean addWhippedCream , boolean addChocolate){
        String summaryInfo =
                "Name: " + nameText +
                "\nAdd whipped cream?"+ addWhippedCream +
                "\nAdd chocolate?"+ addChocolate +
                "\nQuantity: " + quantity +
                "\nTotal: " + price +
                "\nThank you!";
        return summaryInfo;
    }

    //Make sure increment and decrement are both public method
    public void increment(View view){
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view){
        quantity = quantity - 1;
        if(quantity>0) { displayQuantity(quantity);}
        else {quantity = 1;};
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    //This method displays the given text on the screen
    private void displayMessage(String message){
        TextView orderSummaryTextView = (TextView)findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}