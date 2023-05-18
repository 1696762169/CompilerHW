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

        /// <summary>
        /// 进入新作用域
        /// </summary>
        public void EnterScope()
        {
            m_ScopeStack.Push(new Dictionary<string, LLVMValueRef>());
        }
        /// <summary>
        /// 离开作用域
        /// </summary>
        public void ExitScope()
        {
            m_ScopeStack.Pop();
        }

        /// <summary>
        /// 添加符号
        /// </summary>
        public void AddSymbol(string name, LLVMValueRef value)
        {
            m_ScopeStack.Peek()[name] = value;
        }

        /// <summary>
        /// 在所有符号表中获取符号
        /// </summary>
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
        /// <summary>
        /// 在最上层的符号表中获取符号
        /// </summary>
        /// <param name="name"></param>
        /// <returns></returns>
        public LLVMValueRef GetSymbolInTop(string name)
        {
            return m_ScopeStack.Peek().TryGetValue(name, out var value) ? value : new LLVMValueRef(IntPtr.Zero);
        }
    }
}
