using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace kinomix
{
    public partial class Form2 : Form
    {
        
        public Form2()
        {
            InitializeComponent();
        }
        int i = 1;
        int j = 1;
        string vopros(int i) 
        {
        
        string namefile = Convert.ToString("Resources\\" + i + ".txt");
        string vopr = System.IO.File.ReadAllText(namefile, Encoding.GetEncoding(1251));
        return vopr;
        }
        void img (int j)
    {
        string name = Convert.ToString("Resources\\" +  j + ".bmp");
        Bitmap image1 = new Bitmap(name);
        pictureBox1.Image = image1;
    }
        
        private void button1_Click(object sender, EventArgs e)
        {
            label1.Visible = true;
            pictureBox1.Visible = true;
            if (i < 11)
            {
                label1.Text = vopros(i++);
                img(j++);
            }
            else Close();
           
        }
    }
}
