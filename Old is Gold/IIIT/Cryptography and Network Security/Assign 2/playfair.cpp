#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

struct Index
{
    int row;
    int col;
    Index(int r, int c) : row(r), col(c) {}
};

vector<vector<string>> key = {
    {"n", "i", "k", "h", "l"},
    {"b", "w", "t", "a", "m"},
    {"e", "o", "j", "p", "q"},
    {"r", "c", "x", "u", "d"},
    {"s", "f", "v", "y", "z"}};

string getdig(string msg)
{
    for (int i = 0; i < msg.length(); i++)
    {
        if (msg[i] == 'g')
            msg[i] = 'i';
    }
    for (int i = 1; i < msg.length(); i = i + 2)
    {
        if (msg[i - 1] == msg[i])
            msg.insert(i, "x");
    }

    if (msg.length() % 2 != 0)
        msg += "x";

    return msg;
}

Index getIndex(char c)
{
    Index defaultInd(-1, -1);
    for (int i = 0; i < key.size(); i++)
    {
        for (int j = 0; j < key[i].size(); j++)
        {
            if (key[i][j][0] == c)
            {
                Index p(i, j);
                return p;
            }
        }
    }
    return defaultInd;
}

string encryption(string dig)
{
    string ct = "";
    for (int i = 0; i < dig.length(); i += 2)
    {
        Index p1 = getIndex(dig[i]);
        Index p2 = getIndex(dig[i + 1]);

        if (p1.row == p2.row)
        {
            ct += key[p1.row][(p1.col + 1) % 5];
            ct += key[p2.row][(p2.col + 1) % 5];
        }
        else if(p1.col == p2.col)
        {
            ct += key[(p1.row + 1) % 5][p1.col];
            ct += key[(p2.row + 1) % 5][p2.col];
        }

        else
        {
            ct += key[p1.row][p2.col];
            ct += key[p2.row][p1.col];
        }
    }
    return ct;
}

int main()
{
    for (int i = 0; i < key.size(); ++i)
    {
        for (int j = 0; j < key[i].size(); ++j)
        {
            cout << key[i][j] << " ";
        }
        cout << endl;
    }

    string pt = "cryptography and network security";
    pt.erase(remove(pt.begin(), pt.end(), ' '), pt.end());
    string dig = getdig(pt);
    cout << "Formatted Message : " << dig << endl;
    string ct = encryption(dig);
    cout << "Encrypted Message : " << ct << endl;
    return 0;
}
