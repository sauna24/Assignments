using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

//Jimmy Pasehke 930808-3915 jimpas-2       L0002B

namespace upp1
{   /// <summary>
    /// Räknare för växel
    /// </summary>
    public partial class Form1 : Form
    {
        #region Constructor
        /// <summary>
        /// Default constructor
        /// </summary>
        public Form1()
        {
            InitializeComponent();
        }
        #endregion

        int retur, belopp, betalt;
        int fivehundred, hundred, fifty, twenty, ten, five, one;

        private void Reset_Click(object sender, EventArgs e)
        {
            this.UserInputBelopp.Text = string.Empty;       // rensar värderna när man trycker på reset knappen
            this.UserInputBetalt.Text = String.Empty;
            this.txtResultat.Text = string.Empty;
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void txtResultat_TextChanged(object sender, EventArgs e)
        {
            
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void UserInputBetalt_TextChanged(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void Resultat_Click(object sender, EventArgs e)
        {
            belopp = Convert.ToInt32(UserInputBelopp.Text); // konverterar input från UserInputBelopp till INT och sparar det som belopp
            betalt = Convert.ToInt32(UserInputBetalt.Text); // konverterar input från UserInputBetalt till INT och sparar det som betalt
            //txtResult.Text = resultat.ToString();
            retur = belopp - betalt;
            if (retur < 0 ) {
                MessageBox.Show("Du har betalat för mycket");
            };

            fivehundred = retur / 500; //delar värdet av returen med 500 för 500kr osv för att få antalet 500 lappar i retur
            retur %= 500;              //modulus för att ta vidare resten av returen till nästa steg
            hundred = retur / 100;
            retur %= 100;
            fifty = retur / 50;
            retur %= 50;
            twenty = retur / 20;
            retur %= 20;
            ten = retur / 10;
            retur %= 10;
            five = retur / 5;
            retur %= 5;
            one = retur;

            // Kontroller så att bara valörer som ska betalas ut skrivs ut
            if (fivehundred >= 1) { 
                txtResultat.AppendText(fivehundred.ToString() + " Femhundralappar \n");
            };
            if (hundred >= 1)
            {
                txtResultat.AppendText(hundred.ToString() + " Hundralappar \n");
            };
            if (fifty >= 1)
            {
                txtResultat.AppendText(fifty.ToString() + " Femtiolappar \n");
            };
            if (twenty >= 1)
            {
                txtResultat.AppendText(twenty.ToString() + " Tjugolappar \n");
            };
            if (ten >= 1)
            {
                txtResultat.AppendText(ten.ToString() + " Tior \n");
            };
            if (five >= 1)
            {
                txtResultat.AppendText(five.ToString() + " Femmor \n");
            };
            if (one >= 1)
            {
                txtResultat.AppendText(one.ToString() + " enkronor \n");
            };
            if (belopp < 0 || betalt < 0)
            {
                MessageBox.Show("Du har angett ett felagtigt belopp");  // kollar om någon försöker använda negativa nummer
                this.txtResultat.Text = string.Empty;
            }
        }

        private void Result_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
