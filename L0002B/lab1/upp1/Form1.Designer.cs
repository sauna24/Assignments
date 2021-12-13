namespace upp1
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.UserInputBelopp = new System.Windows.Forms.TextBox();
            this.UserInputBetalt = new System.Windows.Forms.TextBox();
            this.Resultat = new System.Windows.Forms.Button();
            this.txtResultat = new System.Windows.Forms.RichTextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.Reset = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // UserInputBelopp
            // 
            this.UserInputBelopp.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.UserInputBelopp.Location = new System.Drawing.Point(44, 25);
            this.UserInputBelopp.Name = "UserInputBelopp";
            this.UserInputBelopp.Size = new System.Drawing.Size(196, 20);
            this.UserInputBelopp.TabIndex = 0;
            this.UserInputBelopp.TextChanged += new System.EventHandler(this.textBox1_TextChanged);
            // 
            // UserInputBetalt
            // 
            this.UserInputBetalt.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.UserInputBetalt.Location = new System.Drawing.Point(44, 82);
            this.UserInputBetalt.Name = "UserInputBetalt";
            this.UserInputBetalt.Size = new System.Drawing.Size(196, 20);
            this.UserInputBetalt.TabIndex = 1;
            this.UserInputBetalt.TextChanged += new System.EventHandler(this.UserInputBetalt_TextChanged);
            // 
            // Resultat
            // 
            this.Resultat.Location = new System.Drawing.Point(44, 250);
            this.Resultat.Name = "Resultat";
            this.Resultat.Size = new System.Drawing.Size(75, 23);
            this.Resultat.TabIndex = 2;
            this.Resultat.Text = "Resultat";
            this.Resultat.UseVisualStyleBackColor = true;
            this.Resultat.Click += new System.EventHandler(this.Resultat_Click);
            // 
            // txtResultat
            // 
            this.txtResultat.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtResultat.Location = new System.Drawing.Point(44, 120);
            this.txtResultat.Name = "txtResultat";
            this.txtResultat.ReadOnly = true;
            this.txtResultat.Size = new System.Drawing.Size(196, 109);
            this.txtResultat.TabIndex = 3;
            this.txtResultat.Text = "";
            this.txtResultat.TextChanged += new System.EventHandler(this.txtResultat_TextChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(44, 6);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(34, 13);
            this.label1.TabIndex = 4;
            this.label1.Text = "Betalt";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(44, 69);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(0, 13);
            this.label2.TabIndex = 5;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(44, 68);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(51, 13);
            this.label3.TabIndex = 6;
            this.label3.Text = "Ange pris";
            // 
            // Reset
            // 
            this.Reset.Location = new System.Drawing.Point(165, 250);
            this.Reset.Name = "Reset";
            this.Reset.Size = new System.Drawing.Size(75, 23);
            this.Reset.TabIndex = 7;
            this.Reset.Text = "Reset";
            this.Reset.UseVisualStyleBackColor = true;
            this.Reset.Click += new System.EventHandler(this.Reset_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(305, 314);
            this.Controls.Add(this.Reset);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txtResultat);
            this.Controls.Add(this.Resultat);
            this.Controls.Add(this.UserInputBetalt);
            this.Controls.Add(this.UserInputBelopp);
            this.Name = "Form1";
            this.Text = "Växel";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox UserInputBelopp;
        private System.Windows.Forms.TextBox UserInputBetalt;
        private System.Windows.Forms.Button Resultat;
        private System.Windows.Forms.RichTextBox txtResultat;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button Reset;
    }
}

