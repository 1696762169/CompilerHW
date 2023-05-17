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
        private StringBuilder jsonBuilder;
        private IList<string> ruleNames;

        public DisplayTree(IList<string> ruleNames)
        {
            this.ruleNames = ruleNames;
            jsonBuilder = new StringBuilder();
        }



        public void Visit(IParseTree tree)
        {
            if (tree.Payload is not RuleContext ctx)
                return;

            jsonBuilder.Append("{ ");
            jsonBuilder.Append("\"Rule\": \"" + ruleNames[ctx.RuleIndex] + "\"");

            if (tree.ChildCount > 0)
            {
                jsonBuilder.Append(", \"Children\": [ ");

                for (int i = 0; i < tree.ChildCount; i++)
                {
                    if (i > 0)
                        jsonBuilder.Append(", ");

                    if (tree.GetChild(i) is RuleContext)
                        Visit(tree.GetChild(i));
                    else
                        jsonBuilder.Append("{\"Token\": \"" + ((CommonToken)tree.GetChild(i).Payload).Text + "\"}");
                }

                jsonBuilder.Append(" ]");
            }

            jsonBuilder.Append(" }");
        }

        public void PrintTreeAsJson()
        {
            Console.WriteLine(jsonBuilder.ToString());
        }

        public void WriteToFileAsJson(string path)
        {
            File.WriteAllText(path, jsonBuilder.ToString());
        }
    }
}
