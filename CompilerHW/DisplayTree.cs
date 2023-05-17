using System;
using System.Collections.Generic;
using System.Drawing;
using System.Text;
using System.Xml.Linq;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;

namespace CompilerHW
{
    internal class DisplayTree
    {
        private readonly StringBuilder m_JsonBuilder;
        private readonly IList<string> m_RuleNames;

        public DisplayTree(IList<string> ruleNames)
        {
            m_RuleNames = ruleNames;
            m_JsonBuilder = new StringBuilder();
        }

        public void Display(IParseTree tree)
        {
            if (tree.Payload is CommonToken token)
            {
                m_JsonBuilder.Append("{\"Token\": \"" + token.Text + "\"}");
                return;
            }
            if (tree.Payload is not RuleContext ctx)
                return;

            m_JsonBuilder.Append("{ ");
            m_JsonBuilder.Append("\"Rule\": \"" + m_RuleNames[ctx.RuleIndex] + "\"");

            if (tree.ChildCount > 0)
            {
                m_JsonBuilder.Append(", \"Children\": [ ");
                for (int i = 0; i < tree.ChildCount; i++)
                {
                    if (i > 0)
                        m_JsonBuilder.Append(", ");
                    Display(tree.GetChild(i));
                }
                m_JsonBuilder.Append(" ]");
            }
            m_JsonBuilder.Append(" }");
        }

        public void PrintTreeAsJson()
        {
            Console.WriteLine(m_JsonBuilder.ToString());
        }

        public void WriteToFileAsJson(string path)
        {
            File.WriteAllText(path, m_JsonBuilder.ToString());
        }
    }
}
