using LLVMSharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CompilerHW
{
    /// <summary>
    /// 符号表类
    /// </summary>
    internal class SymbolTable
    {
        private readonly Stack<Dictionary<string, LLVMValueRef>> m_ScopeStack = new();
        public SymbolTable()
        {
            // 初始时就有一个全局符号表
            m_ScopeStack.Push(new Dictionary<string, LLVMValueRef>());
        }

        // 进入新作用域
        public void EnterScope()
        {
            m_ScopeStack.Push(new Dictionary<string, LLVMValueRef>());
        }
        // 离开作用域
        public void ExitScope()
        {
            m_ScopeStack.Pop();
        }
        // 添加符号
        public void AddSymbol(string name, LLVMValueRef value)
        {
            m_ScopeStack.Peek()[name] = value;
        }
        // 移除符号
        public LLVMValueRef GetSymbol(string name)
        {
            foreach (var scope in m_ScopeStack)
            {
                if (scope.TryGetValue(name, out var value))
                {
                    return value;
                }
            }
            return new LLVMValueRef(IntPtr.Zero);
        }
    }
}
