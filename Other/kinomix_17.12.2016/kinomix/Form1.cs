using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Web;
using System.Net;
using System.Net.Mail;
using System.Net.Mime;
using System.Xml;


namespace kinomix
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

        }

        Form2 a = new Form2();
        Form3 b = new Form3();
        private void button1_Click(object sender, EventArgs e)
        {
            this.Hide();
            a.ShowDialog();
            this.Show();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Hide();
            b.ShowDialog();
            this.Show();
        }

        private void linkLabel1_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            System.Diagnostics.Process.Start("Notepad.exe", "О программе");
        }
    }
}
